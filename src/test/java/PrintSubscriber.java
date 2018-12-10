import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PrintSubscriber implements Observer {

    private final String message;

    public PrintSubscriber(String message) {

        this.message = message;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Object o) {
        System.out.println(message.concat(" :").concat(o.toString()));
    }

    @Override
    public void onError(Throwable e) {

        System.out.println(message.concat(" : Error :").concat(e.getMessage()));
    }

    @Override
    public void onComplete() {
        System.out.println(message.concat("Completed"));
    }
}
