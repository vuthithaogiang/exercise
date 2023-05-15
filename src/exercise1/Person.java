package exercise1;

import java.util.Date;

public abstract class Person implements Comparable<Person> {
    private String id;
    private FullName fullName;
    private String address;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;

    public Person() {

    }

    public Person(String id, String fullName, String address, Date dateOfBirth, String email, String phoneNumber){
        this.id = id;
        setFullName(fullName);
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Person other){
        return id.compareTo(other.id);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public final String getFullNameString() {
        return fullName.last + " " + fullName.mid + " " + fullName.first;
    }

    public FullName getFullName() {
        return fullName;
    }

    public final void setFullName(String fullName){
        this.fullName = new FullName();

        if(fullName != null && fullName.length() > 0) {
            var words = fullName.split("\\s+");
            this.fullName.first = words[words.length - 1];
            this.fullName.last = words[0];
            this.fullName.mid = "";

            for(int i = 1; i < words.length -1 ; i++) {
                this.fullName.mid += words[i] + " ";
            }
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public class FullName{
        private String first;
        private String last;
        private String mid;

        public FullName() {

        }

        public FullName(String first, String last, String mid){
            this.first =first;
            this.last = last;
            this.mid = mid;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }
    }
}
