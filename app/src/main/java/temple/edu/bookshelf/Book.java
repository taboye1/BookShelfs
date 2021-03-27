package temple.edu.bookshelf;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title;
    private String author;

    public Book(){
    };

    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {

            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {

            return new Book[size];
        }
    };

    public String getTitle(){

        return title;
    }
    public String getAuthor() {
        return author;
    }

}
