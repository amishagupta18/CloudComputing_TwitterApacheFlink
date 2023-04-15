# CloudComputing_TwitterApacheFlink
Our group: Amisha Gupta, David Jones, Stuti Patel, and Jennifer Nguyen

-Source Code can be found on the main repository page: LineCountWithSetOfWords.jar <br>
-CSV file that has the tweets for Turkey and Syria Earthquake can be downloaded from the link: <br>
 https://drive.google.com/file/d/1yaxlwj-8AKzUlqOcyQaDgF_aZfJsYq1i/view?usp=sharing

Here's what to do BEFORE running the source code on Apache Flink:
1. Download the Tweets.csv and source code JAR file on to your local/virtual machine

To run the source code on Apache Flink, you can follow the steps listed below:
1. Start a Flink cluster. You can do this by running the start-cluster.sh script in the Flink's bin directory using the command line: ./bin/start-cluster.sh
.**Make sure the first step also starts the web dashboard**
2. Submit your JAR file to the flink cluster two times. You can do this by:   
      a. First, running the following command for negative tweets: 
      <br><img width="425" alt="image" src="https://user-images.githubusercontent.com/104871313/232067251-b9a51914-a9c1-46b0-bb36-2ae834cde2e1.png"><br>
      b. Second, running the following command for positive tweets:
      <br><img width="425" alt="image" src="https://user-images.githubusercontent.com/104871313/232067578-182c90e7-3c16-4a60-9c74-4ed0c075d978.png"><br>
**Step 2 should give you the count of the negative and positive tweets in the file**
3. Monitor the progress of the JAR file. You can do this by visiting the Flink web dashboard at 'http://localhost:8081' 
(assuming you are running Flink locally) or by using the Flink command-line interface. If the JAR file runs successfully, it will output the number of negative and positive tweets.
