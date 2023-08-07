package interview.livecoding;

import java.util.*;

public class VisitCounterMain {

    public static void main(String[] args) {

    }

}

class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
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

    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

}
