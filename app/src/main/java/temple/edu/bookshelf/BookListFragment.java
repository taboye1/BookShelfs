package temple.edu.bookshelf;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class BookListFragment extends Fragment {
    ArrayList<String> books;

    public final static String BOOKS_KEY = "books";

    private OnBookSelectedInterface fragmentParent;

    public BookListFragment() {
        // Required empty public constructor
    }


    public static BookListFragment newInstance(ArrayList<String> books) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(BOOKS_KEY,books);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView listView = (ListView) inflater.inflate(R.layout.fragment_book_list, container, false);

        listView.setAdapter(new ArrayAdapter<>((Context) fragmentParent, android.R.layout.simple_list_item_1, books));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragmentParent.bookSelected(position);
            }
        });

        return listView;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBookSelectedInterface) {
            fragmentParent = (OnBookSelectedInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBookSelectedInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentParent = null;
    }
    public interface OnBookSelectedInterface {
        void bookSelected(int position);
    }

}