import java.util.TimerTask;

public class TimeOutTask extends TimerTask {
    @Override
    public void run() {
        System.out.println();
        System.out.println("이용 시간이 모두 지나 프로그램을 종료합니다.");
        System.exit(0);
    }
}
