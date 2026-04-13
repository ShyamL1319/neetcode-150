class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> userTweets;

    private class Tweet {
        int id;
        int time;
        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        // Max-Heap to store tweets, ordered by time descending
        PriorityQueue<TweetPointer> pq = new PriorityQueue<>((a, b) -> b.tweet.time - a.tweet.time);

        // Add the user to their own "following" set conceptually
        Set<Integer> followed = new HashSet<>(following.getOrDefault(userId, new HashSet<>()));
        followed.add(userId);

        // Add the latest tweet from every followed user into the heap
        for (int followeeId : followed) {
            List<Tweet> tweets = userTweets.get(followeeId);
            if (tweets != null && !tweets.isEmpty()) {
                // Add a pointer to the last tweet in the list
                pq.add(new TweetPointer(tweets, tweets.size() - 1));
            }
        }

        // Extract at most 10 most recent tweets
        while (!pq.isEmpty() && res.size() < 10) {
            TweetPointer tp = pq.poll();
            res.add(tp.tweet.id);
            // If the user has more tweets, add the next most recent one to the heap
            if (tp.index > 0) {
                pq.add(new TweetPointer(tp.list, tp.index - 1));
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    // Helper class to track progress through a user's tweet list
    private class TweetPointer {
        List<Tweet> list;
        int index;
        Tweet tweet;
        TweetPointer(List<Tweet> list, int index) {
            this.list = list;
            this.index = index;
            this.tweet = list.get(index);
        }
    }
}