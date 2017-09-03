drop table Airline;

create table Airline ( RowNum INT, field1 STRING, field2 STRING, field3 STRING, field4 STRING, field5 STRING, field6 STRING, field7 STRING, field8 STRING, field9 STRING, field10 STRING, field11 STRING, field12 STRING, field13 STRING, field14 STRING, field15 STRING, field16 STRING, field17 STRING, field18 STRING, field19 STRING, field20 STRING, field21 STRING, field22 STRING, field23 STRING, field24 STRING, field25 STRING, field26 STRING,field27 STRING, field28 STRING, field29 STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

LOAD DATA LOCAL INPATH '/home/hduser/Desktop/FlightData.txt' into table Airline;

insert overwrite local directory '/home/hduser/Desktop/ArrTimeOp' row format delimited fields terminated by ',' select field17, field18, min(field14) from Airline group by field17,field18;




