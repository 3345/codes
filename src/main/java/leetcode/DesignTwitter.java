package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

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
                Node oldHead = tweets.get(userId);
                Node newHead = new Node(System.nanoTime(), tweetId);
                newHead.next = oldHead;
                tweets.put(userId, newHead);
            } else {
                tweets.put(userId, new Node(System.nanoTime(), tweetId));
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Node> feedHeads = new ArrayList<>();
            if (tweets.containsKey(userId)) {
                feedHeads.add(tweets.get(userId));
            }

            List<Integer> ans = new ArrayList<>();

            if (following.containsKey(userId)) {
                for (Integer followee : following.get(userId)) {
                    if (tweets.containsKey(followee)) {
                        feedHeads.add(tweets.get(followee));
                    }
                }
            }


            if (feedHeads.size() == 0) {
                return ans;
            }

            for (int i = 0; i < 10; i++) {
                Node mostRecent = null;
                Long recentTime = Long.MIN_VALUE;

                for (Node n : feedHeads) {
                    recentTime = Math.max(recentTime, n.ts);
                    if (recentTime == n.ts) {
                        mostRecent = n;
                    }
                }

                if (mostRecent.next != null) {
                    feedHeads.add(mostRecent.next);
                }

                feedHeads.remove(mostRecent);
                ans.add(mostRecent.tweetId);

                if (feedHeads.size() == 0) {
                    return ans;
                }
            }

            return ans;

        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }

            if (following.containsKey(followerId)) {
                following.get(followerId).add(followeeId);
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

    @Test
    public void t() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.follow(2,1);
        twitter.postTweet(2, 6);
        System.out.println(new Gson().toJson(twitter.getNewsFeed(1)));
        System.out.println(new Gson().toJson(twitter.getNewsFeed(2)));

    }
}
