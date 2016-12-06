package leetcode;

import java.util.*;

/**
 * Created by fuyul on 12/6/2016.
 */
public class DesignTwitter {
    public class Twitter {
        public class Node {
            long ts;
            int tweetId;
            Node next;

            public Node (long ts, int tweetId) {
                this.ts = ts;
                this.tweetId = tweetId;
            }
        }

        Map<Integer, Set<Integer>> following = new HashMap<>(); //<follower, followee>
        Map<Integer, Node> tweets = new HashMap<>();

        /** Initialize your data structure here. */
        public Twitter() {
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if (tweets.containsKey(userId)) {
                tweets.get(userId).next = new Node(System.currentTimeMillis(), tweetId);
            } else {
                tweets.put(userId, new Node(System.currentTimeMillis(), tweetId));
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Node> feedHeads = new ArrayList<>();
            feedHeads.add(tweets.get(userId));
            List<Integer> ans = new ArrayList<>();

            for (Integer followee : following.get(userId)) {
                feedHeads.add(tweets.get(followee));
            }

            if (feedHeads.size() == 0) {
                return ans;
            }

            for (int i = 0; i < 10; i++) {
                Node mostRecent = null;
                Long recentTime = Long.MAX_VALUE;

                for (Node n : feedHeads) {
                    recentTime = Math.min(recentTime, n.ts);
                    if (recentTime == n.ts) {
                        mostRecent = n;
                    }
                }

                if (mostRecent.next != null) {
                    feedHeads.add(mostRecent.next);
                }

                feedHeads.remove(mostRecent);

                if (feedHeads.size() == 0) {
                    break;
                }
            }

            return ans;

        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (following.containsKey(followeeId)) {
                following.get(followeeId).add(followeeId);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(followeeId);
                following.put(followerId, set);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (following.containsKey(followerId)) {
                following.get(followerId).remove(followeeId);
            }
        }
    }
}
