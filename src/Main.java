import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        Student student = new Student();
        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");

            System.out.print("Chọn chức năng: ");
            int chon = scanner.nextInt();

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã sinh viên: ");
                    int ma = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên sinh viên: ");
                    String ten = scanner.nextLine();
                    ten = ten.replaceAll("[^\\p{L}\\s]", "");
                    System.out.print("Nhập tuổi sinh viên: ");
                    int tuoi = scanner.nextInt();
                    Student sv = new Student(ma, ten, tuoi);
                    studentService.addStudent(sv);
                    break;
                case 2:
                    System.out.print("Nhập mã sinh viên cần sửa: ");
                    int maSua = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String tenMoi = scanner.nextLine();
                    tenMoi = tenMoi.replaceAll("[^\\p{L}\\s]", "");
                    System.out.print("Nhập tuổi mới: ");
                    int tuoiMoi = scanner.nextInt();
                    studentService.editStudent(maSua, tenMoi, tuoiMoi);
                    System.out.println("Sửa thông tin sinh viên thành công.");
                    break;
                case 3:
                    System.out.println("nhập mã sinh viên cần xóa");
                    int maXoa = scanner.nextInt();
                    studentService.removeStudent(maXoa);
                    break;
                case 4:
                    studentService.listStudent();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

}


