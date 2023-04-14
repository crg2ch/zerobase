class Pager {
    long totalCount;
    long numOfPages = 10;
    long numOfBlock = 10;
    long lastBlock;

    Pager(long totalCount) {
        this.totalCount = totalCount;
        this.lastBlock = totalCount / numOfPages;
        if (totalCount % numOfPages > 0) {
            this.lastBlock++;
        }
    }

    public String html(long pageIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("\n<head>");
        sb.append("\n\t <meta charset=\"UTF-8\"/>");
        sb.append("\n\t <style>.on {color: #ff0000;}</style>");
        sb.append("\n</head>");
        sb.append("\n<body>");
        sb.append("\n <a href=\"#\">[처음]</a> ");
        sb.append("<a href=\"#\">[이전]</a> ");
        long start = (pageIndex / numOfBlock) * numOfBlock + 1;
        for (int i = 0; i < (int) numOfBlock; i++) {
            long cur = start + (long) i;
            if (cur == pageIndex) {
                sb.append(String.format("<a href=\"#\" class=\"on\">%d</a> ", cur));
            } else {
                sb.append(String.format("<a href=\"#\">%d</a> ", cur));
            }
            if (cur == lastBlock) {
                break;
            }
        }
        sb.append("<a href=\"#\">[다음]</a> ");
        sb.append("<a href=\"#\">[마지막]</a> ");
        sb.append("\n</body>");
        sb.append("\n</html>");
        return sb.toString();
    }
}

public class Mission1_3 {
    public static void main(String[] args) {
        long totalCount = 127;
        long pageIndex = 5;

        Pager pager = new Pager(totalCount);
        System.out.println(pager.html(pageIndex));
    }
}
