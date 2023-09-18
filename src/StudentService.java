import java.util.*;

public class StudentService {

    public List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {

        int maSinhVienMoi = student.getId();

        boolean existed = false;
        for (Student existingStudent : studentList) {
            if (existingStudent.getId() == maSinhVienMoi) {
                existed = true;
                break;
            }
        }
        if (!existed) {
            studentList.add(student);
            System.out.println("Thêm sinh viên thành công.");
        } else {
            System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập mã khác.");
        }
    }

    public void editStudent(int maSinhVien, String tenMoi, int tuoiMoi, boolean status) {
        for (Student sv : studentList) {
            if (getId(maSinhVien, sv)) {
                sv.setName(tenMoi);
                sv.setAge(tuoiMoi);
                sv.setActive(status);
                break;
            }
        }
    }

    public String removeStudent(int maSinhVien) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (getId(maSinhVien, student)) {
                iterator.remove();
                System.out.println("Xóa thành công");
                return "Xóa thành công";
            }
        }
        System.out.println("Mã sinh viên không tồn tại");
        return "Mã sinh viên không tồn tại";
    }


    public void listStudent() {
        boolean swapped;
        int n = studentList.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (studentList.get(i).getAge() > studentList.get(i + 1).getAge()) {
                    Student temp = studentList.get(i);
                    studentList.set(i, studentList.get(i + 1));
                    studentList.set(i + 1, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        System.out.println("Danh sách Sinh Viên :");

        for (Student sv : studentList) {
            System.out.println(sv);
        }
    }

    public boolean getId(int maSinhVien, Student student) {
        return student.getId() == maSinhVien;

    }
    public String removeStudentsByNameAndStatus(String name, boolean status) {
        boolean removed = false;
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().startsWith(name) && !student.isActive()) {
                iterator.remove();
                removed = true;
            }
        }
        if (removed) {
            System.out.println("Xóa thành công");
            return "Xóa thành công";
        } else {
            System.out.println("Không tìm thấy sinh viên  để xóa");

            return "Xóa thành công";
        }
    }

}


