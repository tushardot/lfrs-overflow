package com.liferay.mail.client.dto.v1_0;

import com.liferay.mail.client.function.UnsafeSupplier;
import com.liferay.mail.client.serdes.v1_0.MailSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Mail implements Cloneable, Serializable {

	public static Mail toDTO(String json) {
		return MailSerDes.toDTO(json);
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> EmailUnsafeSupplier) {

		try {
			Email = EmailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String Email;

	@Override
	public Mail clone() throws CloneNotSupportedException {
		return (Mail)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Mail)) {
			return false;
		}

		Mail mail = (Mail)object;

		return Objects.equals(toString(), mail.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MailSerDes.toJSON(this);
	}

}