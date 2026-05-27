public class OutputView {
    public void running() {
        InputView inputView = new InputView();

        System.out.println("온라인 강의 시스템입니다.");

        inputView.wantService();    // 이용하기 or 종료하기 입력 받기

        System.out.println("서비스를 종료합니다.");
        System.out.println("이용해주셔서 감사합니다.");
    }
}
