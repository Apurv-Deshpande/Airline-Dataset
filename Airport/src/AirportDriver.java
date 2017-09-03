import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


public class AirportDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		
		conf.set("fs.defaultFS", "hdfs://localhost:54310");
		conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName() );
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(AirportDriver.class);
		// TODO: specify a mapper
		job.setMapperClass(AirportMapper.class);
		// TODO: specify a reducer
		job.setReducerClass(AirportReducer.class);

		// TODO: specify output types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.addInputPath(job, new Path("hdfs://localhost:54310/user/hduser/Flight"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:54310/user/hduser/Flight/output"));

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
