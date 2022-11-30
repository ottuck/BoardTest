import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Bbs {

    private Scanner s;
    private List<String[]> bbsList;

    private int seq;

    public Bbs() {
        this.s = new Scanner(System.in);
        this.bbsList = new ArrayList<String[]>();

        this.seq = 1;
    }

    public void readme() {
        System.out.println("1. 등록, 2. 상세보기, 3. 수정, 4. 삭제, 5. 목록, x. 종료");
    }

    public void exit() {
        System.out.println("프로그램을 종료 합니다.");
    }

    public String getInput() {
        return this.s.next();
    }

    public void create() {
        String no = String.valueOf(seq);

        System.out.println("input title...");
        String title = getInput();

        System.out.println("input content...");
        String content = getInput();

        String[] bbs = new String[3];
        bbs[0] = no;
        bbs[1] = title;
        bbs[2] = content;

        this.bbsList.add(bbs);

        this.seq++;

        System.out.println("등록이 완료 되었습니다.");
    }

    private String[] getSearch(String no) {
        for (String[] bbs : this.bbsList) {
            if (bbs != null && bbs[0].equals(no)) {
                return bbs;
            }
        }

        return null;
    }

    public void read(String no) {
        if (no == null || no == "") {
            System.out.println("잘못 입력 하셨습니다.");
            return;
        }

        String[] bbs = this.getSearch(no);

        if (bbs == null) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        System.out.println("no: " + bbs[0]);
        System.out.println("title: " + bbs[1]);
        System.out.println("content: " + bbs[2]);
    }

    public void update(String no) {
        if (no == null || no == "") {
            System.out.println("잘못 입력 하셨습니다.");
            return;
        }

        String[] bbs = this.getSearch(no);

        if (bbs == null) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        System.out.println("input title...");
        String title = this.getInput();

        System.out.println("input content...");
        String content = this.getInput();

        bbs[1] = title;
        bbs[2] = content;

        System.out.println("수정이 완료 되었습니다.");
    }

    public void delete(String no) {
        if (no == null || no == "") {
            System.out.println("잘못 입력 하셨습니다.");
            return;
        }

        String[] bbs = this.getSearch(no);

        if (bbs == null) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        this.bbsList.remove(bbs);

        System.out.println("삭제가 완료 되었습니다.");
    }

    public void getList() {
        for (String[] bbs : this.bbsList) {
            if (bbs != null) {
                System.out.println("no: " + bbs[0]);
                System.out.println("title: " + bbs[1]);
                System.out.println("content: " + bbs[2]);
            }
        }
    }

    public static void main(String[] args) {

        Bbs bbs = new Bbs();

        while(true) {
            bbs.readme();

            String choice = bbs.getInput();

            if (choice.equals("1")) {
                bbs.create();
            } else if (choice.equals("2")) {
                System.out.println("번호를 입력해 주십시오.");
                bbs.read(bbs.getInput());
            } else if (choice.equals("3")) {
                System.out.println("번호를 입력해 주십시오.");
                bbs.update(bbs.getInput());
            } else if (choice.equals("4")) {
                System.out.println("번호를 입력해 주십시오.");
                bbs.delete(bbs.getInput());
            } else if (choice.equals("5")) {
                bbs.getList();
            } else if (choice.equals("x")) {
                bbs.exit();
                break;
            } else {
                System.out.println("잘못 입력 하셨습니다.\n다시 입력해 주십시오.");
            }
        }
    }
}