import java.io.IOException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class FlightMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
    IntWritable b = new IntWritable();
    private Text word = new Text();
    
    String a;
    String d;
    int c=0;
    String ad;
   
    public void map(LongWritable ikey, Text ivalue, Context context)
            throws IOException, InterruptedException
    {
       
        String[] line = ivalue.toString().split(",");
        a = line[1];
        d = line[2];
     ad= d.concat("-").concat(a);     
        
     c=1;
        word.set(ad);
        b.set(c);
        
  context.write(word,new IntWritable(1));
        
        
    }

}







