import java.io.IOException;
import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class AirportMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
    IntWritable b = new IntWritable();
    private Text word = new Text();
    
    String a;
    int c=0;
   
    public void map(LongWritable ikey, Text ivalue, Context context)
            throws IOException, InterruptedException
    {
       
        String[] line = ivalue.toString().split(",");
        a = line[17];
        c=1;
        word.set(a);
        b.set(c);
        
        
        context.write(word,new IntWritable(1));
        
        
    }

}






