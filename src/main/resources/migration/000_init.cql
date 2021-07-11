CREATE KEYSPACE video_streaming_schema
WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : '2'};

CREATE TABLE video_streaming_schema.video(
                               id text PRIMARY KEY,
                               title text,
                               description text
);