import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.util.Collector;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LineCountWithSetOfWords {

    public static void main(String[] args) throws Exception {

        // obtain execution environment and set configuration parameters
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        ParameterTool params = ParameterTool.fromArgs(args);
        env.getConfig().setGlobalJobParameters(params);

        // read input file and create set of words to check
        DataSet<String> lines = env.readTextFile(params.get("input"));
        Set<String> wordsToCheck = new HashSet<>(Arrays.asList(params.get("words").split(",")));

        // flatMap each line to emit lines that contain any one of the words to check
        DataSet<String> matchingLines = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String line, Collector<String> out) throws Exception {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (wordsToCheck.contains(word)) {
                        out.collect(line);
                        break;
                    }
                }
            }
        });

        // count the number of matching lines and output the result
        long count = matchingLines.count();
        System.out.println("Number of lines that contain any one of the words: " + count);

        // execute the Flink job
        env.execute("Line Count with Set of Words");
    }
}
