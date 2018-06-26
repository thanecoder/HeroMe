package nichat.com.herome.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

import nichat.com.herome.R;
import nichat.com.herome.activities.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondFragment.OnSecondFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button nextBtn;
    Button poption1;
    Button poption2;
    Button poption3;
    Button poption4;
    Button poption5;
    Button poption6;
    Button poption7;
    Button poption8;
    Button poption9;
    Button poption10;

    ArrayList<Integer> powers= new ArrayList<Integer>(2);


    private OnSecondFragmentInteractionListener mListener;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_second, container, false);
        nextBtn = (Button)view.findViewById(R.id.nextBtn);
        poption1 = (Button)view.findViewById(R.id.poption1);
        poption2 = (Button)view.findViewById(R.id.poption2);
        poption3 = (Button)view.findViewById(R.id.poption3);
        poption4 = (Button)view.findViewById(R.id.poption4);
        poption5 = (Button)view.findViewById(R.id.poption5);
        poption6 = (Button)view.findViewById(R.id.poption6);
        poption7 = (Button)view.findViewById(R.id.poption7);
        poption8 = (Button)view.findViewById(R.id.poption8);
        poption9 = (Button)view.findViewById(R.id.poption9);
        poption10 = (Button)view.findViewById(R.id.poption10);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity =(MainActivity)getActivity();
                mainActivity.loadFinalFragment();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSecondFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSecondFragmentInteractionListener) {
            mListener = (OnSecondFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSecondFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSecondFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSecondFragmentInteraction(Uri uri);
    }
}
