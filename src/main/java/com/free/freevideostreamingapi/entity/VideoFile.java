package com.free.freevideostreamingapi.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table
public class VideoFile {

    @Id
    @PrimaryKey
    @Column("id")
    String id;

    @Column("title")
    String title;

    @Column("description")
    String description;

    @Column("input_dir")
    String inputDir;

    @Column("output_dir")
    String outputDir;

    @Column("manifest_filename")
    String manifestFile;

    @Column("filename")
    String filename;

    @Column("original_filename")
    String originalFilename;


}
