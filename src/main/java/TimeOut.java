public class TimeOut extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 60);    // 제한 시간 1분

            System.out.println();
            System.out.println("----------------------");
            System.out.println("이용 시간이 모두 지나 서비스를 종료합니다.");

            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
