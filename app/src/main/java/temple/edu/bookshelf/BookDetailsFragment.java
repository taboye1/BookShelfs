package temple.edu.bookshelf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BookDetailsFragment extends Fragment {
    TextView textView;
    String title;
    public static final String BOOK_TITLE_KEY = "book title";

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    public static BookDetailsFragment newInstance(String title) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putString(BOOK_TITLE_KEY, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        textView = (TextView) inflater.inflate(R.layout.fragment_book_details, container, false);
        if (title != null) {
            displayBook(title);
        }
        return textView;
    }


    public void displayBook(String title) {

        textView.setGravity(Gravity.CENTER);
        textView.setText(title);
        textView.setTextSize(24);
    }
}