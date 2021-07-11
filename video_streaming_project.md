1. Backend Cassandra + Amazon S3

2. Data Types: 

User {
	id, 
	username,
	email,
	password,
	list<string> myChannelIds,
	list<string> channelSubscribeIds,
	string libraryId,
	string roleId
}

Role {
	id,
	code
    name,
}

Video {
	id,
	title,
	desc,
	input_dir,
	output_dir,
	manifest_file,
	filename,
	original_filename,
	string videoStatsId,
	list<string> videoFrameIds,
	list<string> picturesUrls,
} 

VideoFrame {
	id,
	videoId,
	filename,
	bucket_name,
	key_name
}

VideoStats {
	id,
	videoId,	
	int viewsNum,
	int likesNum,
	int dislikesNum
}

VideoTimeCode {
	id,
	videoId,
	timeCode,
	description
}

Like {
	likeId,
	userId,
	videoId,
	commentId,
	objectType = video, comment
	toneType = like, dislike
}

Subscribe {
	userId,
	videoId,
	state,
	subscribe_datetime
}

Comment {
	id,
	parentId,
	userId,
	videoId,
	text,
	int likesNum
}

Channel {
	id,
	userId,
	title,
	desc,
	list<string> videoIds,
	list<string> playlistIds
}

Playlist {
	string id,
	string userId,
	list<string> playListItemIds,
	int videosNum,
	title
}

PlayListItem {
	string playlistId,
	string videoId,
	timestamp addingDatetime
}

Library {
	id,
	userId,
	list<string> playlistIds,
	title 
}

Recommendations {
    RecommendationItem {
        userId,
        videoId,
        recommendationDate,
        priority,
        videoCreatedAt,
        videoTitle,
        videoText   
    }
}

3. Use cases for user

3.1. Register user
3.2. Login
3.3. Choose and watch video 
3.4. Add video to library
3.4.1. Choose picture for video
3.5. Remove video from library 
3.6. Subscribe on channel

4. Use cases for manager

4.1. Watch user lists
4.2. Block user
4.3. Watch video lists
4.4. Block video
4.5. Monitor recently uploaded videos
4.6. Authoriza recently uploaded lists

----------------------------------------------------------------


