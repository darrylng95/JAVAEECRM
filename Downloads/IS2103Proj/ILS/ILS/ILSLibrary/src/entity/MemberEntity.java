package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import util.enumeration.GenderEnum;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
@Entity
public class MemberEntity implements Serializable {
    
    
   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column (nullable = false)
   private Long memberId;
   
   @OneToMany(mappedBy = "memberEntity")
   private List<LendingEntity> lendingEntities;
   
   @OneToMany(mappedBy = "memberEntity")
   private List<ReservationEntity> reservationEntities;
   
   @Column(nullable = false)
   private String securityCode;
   
   @Column(nullable = false)
   private String firstName;

   @Column(nullable = false)
   private String lastName;
   
   @Enumerated(EnumType.STRING)
   private GenderEnum gender; 

   @Column(nullable = false)
   private Integer age;
   
   @Column(nullable = false , unique = true)
   private String identityNumber;
   
   @Column(nullable = false)
   private String phone;
   
   @Column(nullable = false)
   private String address;
    
    public MemberEntity() {
    
    }

    public MemberEntity(String securityCode, String firstName, String lastName, GenderEnum gender, Integer age, String identityNumber, String phone, String address) {
        this.lendingEntities = new LinkedList<LendingEntity>();
        this.reservationEntities = new LinkedList<ReservationEntity>();
        this.securityCode = securityCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.identityNumber = identityNumber;
        this.phone = phone;
        this.address = address;
    }

        public MemberEntity(String securityCode, String identityNumber, String firstName, String lastName, GenderEnum gender, Integer age, String phone, String address) {
        this.lendingEntities = new LinkedList<LendingEntity>();
        this.reservationEntities = new LinkedList<ReservationEntity>();
        this.securityCode = securityCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.identityNumber = identityNumber;
        this.phone = phone;
        this.address = address;
    }
    
    
    
    public List<LendingEntity> getLendingEntities() {
        return lendingEntities;
    }

    public List<ReservationEntity> getReservationEntities() {
        return reservationEntities;
    }

    public void setLendingEntities(List<LendingEntity> lendingEntities) {
        this.lendingEntities = lendingEntities;
    }

    public void setReservationEntities(List<ReservationEntity> reservationEntities) {
        this.reservationEntities = reservationEntities;
    }
   
    public Long getMemberId() {
        return memberId;
    }
   
    public void setMemberId(Long id) {
        this.memberId = id;
    }
    
    
    public String getSecurityCode(){
        return securityCode;
    }
    
    public void setSecurityCode(String securityCode){
        this.securityCode = securityCode;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
    
    public String getIdentityNumber(){
        return identityNumber;
    }
    
    public void setIdentityNumber(String identityNumber){
        this.identityNumber = identityNumber;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getAddress(){
        
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the memberId fields are not set
        if (!(object instanceof MemberEntity)) {
            return false;
        }
        MemberEntity other = (MemberEntity) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MemberEntity[ id=" + memberId + " ]";
    }    
    
    
    
    
    
}
