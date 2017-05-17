package me.sekitaka.pendingintentextra;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Takashi Seki on 2017/05/15.
 */

public class ParcelablePlayer implements Parcelable {
    int id;
    String name;

    public ParcelablePlayer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected ParcelablePlayer(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ParcelablePlayer> CREATOR = new Creator<ParcelablePlayer>() {
        @Override
        public ParcelablePlayer createFromParcel(Parcel in) {
            return new ParcelablePlayer(in);
        }

        @Override
        public ParcelablePlayer[] newArray(int size) {
            return new ParcelablePlayer[size];
        }
    };

    @Override
    public String toString() {
        return "{" + id + ":" + name + "}";
    }

}
