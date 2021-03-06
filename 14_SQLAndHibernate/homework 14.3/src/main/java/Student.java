import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToMany(mappedBy = "studentsList")
    private List<Course> courseList;

    @OneToMany(mappedBy = "student")
    private List<Subscription> subscriptionList;

    @OneToMany(mappedBy = "student")
    private List<LinkedPurchaseList> linkedPurchaseLists;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "LinkedPurchaseList",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseListFromLinkedPurchaseList;

    public List<Course> getCourseListFromLinkedPurchaseList() {
        return courseListFromLinkedPurchaseList;
    }

    public void setCourseListFromLinkedPurchaseList(List<Course> courseListFromLinkedPurchaseList) {
        this.courseListFromLinkedPurchaseList = courseListFromLinkedPurchaseList;
    }

    public List<LinkedPurchaseList> getLinkedPurchaseLists() {
        return linkedPurchaseLists;
    }

    public void setLinkedPurchaseLists(List<LinkedPurchaseList> linkedPurchaseLists) {
        this.linkedPurchaseLists = linkedPurchaseLists;
    }

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
