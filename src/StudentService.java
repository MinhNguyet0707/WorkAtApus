import java.util.*;

public class StudentService {

    public List<Student> studentList = new ArrayList<>();

    public void addSinhVien(Student student) {

        int maSinhVienMoi = student.getId();

        boolean daTonTai = false;
        for (Student existingStudent : studentList) {
            if (existingStudent.getId() == maSinhVienMoi) {
                daTonTai = true;
                break;
            }
        }
        if (!daTonTai) {
            studentList.add(student);
            System.out.println("Thêm sinh viên thành công.");
        } else {
            System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập mã khác.");
        }
    }

    public void editStudent(int maSinhVien, String tenMoi, int tuoiMoi) {
        for (Student sv : studentList) {
            if (sv.getId() == maSinhVien) {
                sv.setName(tenMoi);
                sv.setAge(tuoiMoi);
                break;
            }
        }
    }

    public String removeStudent(int maSinhVien) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getId() == maSinhVien) {
                iterator.remove();
                System.out.println("xoa thanh cong");
            }
        }
        return "Ma sinh vien khong ton tai";

    }

    public void listStudent() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });


        System.out.println("Danh sach Sinh Vien");

        for (Student sv : studentList) {

            System.out.println(sv);
        }
    }


}
