package development_topics.Design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Observer_pattern {
    public static void main(String[] args) {
        YouTubChannel channel = new YouTubChannel("prateek tech");
        User u1 = new User("vikash");
        User u2 = new User("sunny");

        channel.subscribe(u1);
        channel.subscribe(u2);
        channel.uploadNewVideo("how make a website");
        channel.unSubscribe(u2);
        channel.uploadNewVideo("how make a AI model");


    }
}
interface Observer{
    public void update(String message);
}
interface Subject{
    public void subscribe(Observer o);
    public void unSubscribe(Observer o);
    public void notify(String message);
}
class YouTubChannel implements Subject{
    private List<Observer> subscribers = new ArrayList<>();
    private String channelName;
    public YouTubChannel(String name){
        this.channelName = name;
    }

    @Override
    public void subscribe(Observer o) {
        subscribers.add(o);

    }

    @Override
    public void unSubscribe(Observer o) {
        subscribers.remove(o);

    }

    @Override
    public void notify(String message) {
        for (Observer i :subscribers){
            i.update(message);
        }
        }
    public void uploadNewVideo(String title){
        System.out.println(channelName+" uploaded "+title);
        notify(" new video " + title);
    }
}
class User implements Observer{
    private String name;
    public User(String name){
        this.name= name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+" notified: "+message);
    }
}
