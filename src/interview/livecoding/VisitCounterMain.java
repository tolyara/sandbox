package interview.livecoding;

import java.util.*;

public class VisitCounterMain {

    public static void main(String[] args) {
        Map<String, UserStats> userStatsMap = new HashMap<>();
        userStatsMap.put("1", new UserStats(Optional.of(11L)));
        userStatsMap.put("2", new UserStats(Optional.of(12L)));

        Map<String, UserStats> userStatsMap2 = new HashMap<>();
        userStatsMap2.put("3", new UserStats(Optional.of(13L)));
        userStatsMap2.put("4", new UserStats(Optional.of(14L)));
        userStatsMap2.put("5", new UserStats(Optional.of(15L)));

//        Object[] arr = new Object[2];
//        Map<String, UserStats>[] arr = new Map<String, UserStats>[2];

//        List<Map<String, UserStats>> list = Arrays.asList(userStatsMap, userStatsMap2);

//        new VisitCounter().count(arr);
    }

}

class VisitCounter {

    /*
        Key - user id
        Value - count of visits of
     */
    public Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null || visits.length == 0) {
            return Collections.emptyMap();
        }

        Map<Long, Long> result = new HashMap<>();
        for (Map<String, UserStats> visit : visits) {
            Set<Map.Entry<String, UserStats>> entrySet = visit.entrySet();
            for (Map.Entry<String, UserStats> entry : entrySet) {
                String userId = entry.getKey();
                if (result.containsKey(userId)) {
                    Long currentCount = result.get(userId);
                    Optional<Long> newCount = entry.getValue().getVisitCount();
                    if (newCount.isPresent()) {
                        long resultCount = currentCount.intValue() + newCount.get().intValue();
                        Long userID = Long.parseLong(userId);
                        result.put(userID, resultCount);
                    }
                } else {
                    Optional<Long> visitCount = entry.getValue().getVisitCount();
                    if (visitCount.isPresent()) {
                        Long userID = Long.parseLong(userId);
                        result.put(userID, visitCount.get());
                    }
                }
            }
        }
        return result;
    }
}

class UserStats {

    private Optional<Long> visitCount;

    public UserStats(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

}
