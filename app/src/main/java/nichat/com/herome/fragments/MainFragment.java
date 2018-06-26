package nichat.com.herome.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nichat.com.herome.R;
import nichat.com.herome.activities.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnMainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


//Important note :- In a fragment working with buttons and other views should be done in the onCreateView method and not in onCreate method.

public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Button option1,option2,option3,chooseBtn;

    private OnMainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        option1=(Button)view.findViewById(R.id.option1);
        option2=(Button)view.findViewById(R.id.option2);
        option3=(Button)view.findViewById(R.id.option3);
        chooseBtn=(Button)view.findViewById(R.id.chooseBtn);

        chooseBtn.setEnabled(false);
        chooseBtn.getBackground().setAlpha(128);


        View.OnClickListener optionChoose = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseBtn.setEnabled(true);
                chooseBtn.getBackground().setAlpha(255);

                Button btn =(Button)view;

                switch(btn.getId()){
                    case R.id.option1:
                        btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning_icon,0,R.drawable.item_selected_btn,0);
                        option2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic_icon,0,0,0);
                        option3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket_icon,0,0,0);
                        break;
                    case R.id.option2:
                        option1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
                        btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic_icon,0,R.drawable.item_selected_btn,0);
                        option3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket_icon,0,0,0);
                        break;
                    case R.id.option3:
                        option1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
                        option2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic_icon,0,0,0);
                        btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket_icon,0,R.drawable.item_selected_btn,0);
                        break;
                }

            }
        };

        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadSecondFragment();
            }
        });

        option1.setOnClickListener(optionChoose);
        option2.setOnClickListener(optionChoose);
        option3.setOnClickListener(optionChoose);


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMainFragmentInteractionListener) {
            mListener = (OnMainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public interface OnMainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}