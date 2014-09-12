package fr.epf.computerdatabase.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="computer")
public class Computer {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="introduced")
	private Timestamp introduced;
	@Column(name="discontinued")
	private Timestamp discontinued;
	@Column(name="company_id")
	private Long id_company;

	public Computer() {
	}

	public Computer(Long id, String name, Timestamp introduced,
			Timestamp discontinued, Long id_company) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.id_company = id_company;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Computer computer;

		private Builder() {
			computer = new Computer();
		}

		public Builder id(Long id) {
			computer.id = id;
			return this;
		}

		public Builder name(String name) {
			computer.name = name;
			return this;
		}

		public Builder introduced(Timestamp introduced) {
			computer.introduced = introduced;
			return this;
		}

		public Builder discontinued(Timestamp discontinued) {
			computer.discontinued = discontinued;
			return this;
		}

		public Builder id_company(Long id_company) {
			computer.id_company = id_company;
			return this;
		}

		public Computer build() {
			return computer;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getIntroduced() {
		return introduced;
	}

	public void setIntroduced(Timestamp introduced) {
		this.introduced = introduced;
	}

	public Timestamp getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Timestamp discontinued) {
		this.discontinued = discontinued;
	}

	public Long getId_company() {
		return id_company;
	}

	public void setId_company(Long id_company) {
		this.id_company = id_company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((discontinued == null) ? 0 : discontinued.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_company == null) ? 0 : id_company.hashCode());
		result = prime * result
				+ ((introduced == null) ? 0 : introduced.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (discontinued == null) {
			if (other.discontinued != null)
				return false;
		} else if (!discontinued.equals(other.discontinued))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_company == null) {
			if (other.id_company != null)
				return false;
		} else if (!id_company.equals(other.id_company))
			return false;
		if (introduced == null) {
			if (other.introduced != null)
				return false;
		} else if (!introduced.equals(other.introduced))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introduced="
				+ introduced + ", discontinued=" + discontinued
				+ ", id_company=" + id_company + "]";
	}

}
