package com.training.passingpercelableobjects;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
	public String name;
	public String mobile;

	public Contact(Parcel in) {
		name = in.readString();
		mobile = in.readString();

	}

	public Contact(String name, String mobile) {
		this.name = name;
		this.mobile = mobile;

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(mobile);

	}

	public static final Creator<Contact> CREATOR = new Creator<Contact>() {

		@Override
		public Contact createFromParcel(Parcel source) {
			return new Contact(source);
		}

		@Override
		public Contact[] newArray(int size) {
			return new Contact[size];
		}
	};
}
