package ioprogramming.designpattern;
import java.util.*;

/*
 Observer Pattern
 Notify observers when state changes
*/

interface Subscriber {
    void update(String news);
}

interface Publisher {
    void subscribe(Subscriber s);
    void notifySubscribers();
}

class NewsPublisher implements Publisher {

    List<Subscriber> subs = new ArrayList<>();
    String news;

    public void subscribe(Subscriber s) {
        subs.add(s);
    }

    public void setNews(String n) {
        news = n;
        notifySubscribers();
    }

    public void notifySubscribers() {

        for (Subscriber s : subs)
            s.update(news);
    }
}

class MobileUser implements Subscriber {

    public void update(String news) {
        System.out.println("Mobile received: " + news);
    }
}

public class NewsSystem {

    public static void main(String[] args) {

        NewsPublisher pub = new NewsPublisher();
        MobileUser user = new MobileUser();

        pub.subscribe(user);
        pub.setNews("Breaking News!");
    }
}