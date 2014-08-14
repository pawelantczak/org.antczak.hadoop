DROP TABLE IF EXITS word_sentiment;

CREATE EXTERNAL TABLE word_sentiment (
    id  BIGINT,
    word STRING
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'
STORED AS TEXTFILE
LOCATION '/user/krr/output/xd/holidays/words';