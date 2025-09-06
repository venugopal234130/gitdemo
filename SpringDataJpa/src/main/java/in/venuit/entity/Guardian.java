package in.venuit.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	@AttributeOverride(
			name="guardianName",column=@Column(name="guradian_name")),
	@AttributeOverride(
			name="guardianEmail",column=@Column(name="guardian_email")),
	@AttributeOverride(
			name="guardianMobile",column=@Column(name="guardian_mobile")),		
})
public class Guardian {

	private String guradianName;
	private String guardianEmail;
	private String guardianMobile;
	
	public String getGuradianName() {
		return guradianName;
	}
	public void setGuradianName(String guradianName) {
		this.guradianName = guradianName;
	}
	public String getGuardianEmail() {
		return guardianEmail;
	}
	public void setGuardianEmail(String guardianEmail) {
		this.guardianEmail = guardianEmail;
	}
	public String getGuardianMobile() {
		return guardianMobile;
	}
	public void setGuardianMobile(String guardianMobile) {
		this.guardianMobile = guardianMobile;
	}
}
