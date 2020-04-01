package com.crossover.techtrial.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

/**
 * Panel class hold information related to a Solar panel.
 * 
 * @author Crossover
 *
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

  private static final long serialVersionUID = -8527695980909864257L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @NotNull
  @Column(name = "fullname")
  String fullname;

  @NotNull
  @Column(name = "mobile")
  String mobile;

  @NotNull
  @Column(name = "email")
  String email;

  @Nullable
  @Column(name = "address")
  String address;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getmobile() {
    return mobile;
  }

  public void setLongitude(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  /*
   * Id, Serial and Brand are only fields required to uniquely identify a Panel
   * 
   * @see java.lang.Object#hashCode()
   */
 /* @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((serial == null) ? 0 : serial.hashCode());
    return result;
  }*/

  /*
   * Id, Serial and Brand are only fields required to uniquely identify a Panel
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
 /* @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Panel other = (Panel) obj;
    if (brand == null) {
      if (other.brand != null) {
        return false;
      }
    } else if (!brand.equals(other.brand)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (serial == null) {
      if (other.serial != null) {
        return false;
      }
    } else if (!serial.equals(other.serial)) {
      return false;
    }
    return true;
  }*/

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Panel [id=" + id + ", fullname=" + fullname + ", longitude=" + mobile + ", latitude="
        + email + ", brand=" + address + "]";
  }
}
