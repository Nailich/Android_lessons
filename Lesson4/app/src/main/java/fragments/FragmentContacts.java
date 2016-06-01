package fragments;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.sax.RootElement;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.stonefist.lesson4.R;
import ru.stonefist.lesson4.contact;
import ru.stonefist.lesson4.customAdapter;

public class FragmentContacts extends android.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String[] contacts;
    ListView contactsList;
    List<contact> contacts1 = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public FragmentContacts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentContacts.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContacts newInstance(String param1, String param2) {
        FragmentContacts fragment = new FragmentContacts();
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
        View v = inflater.inflate(R.layout.fragment_contacts2, container, false);
        ListView lv = (ListView) v.findViewById(R.id.lv);
        assert lv != null;
        lv.setAdapter(new customAdapter(loadData()));
        final customAdapter customAdapter = new customAdapter(loadData());
        lv.setAdapter(customAdapter);
        return v;
    }

    public List<contact> loadData() {
        for(int i =0; i<6;i++){
            contacts1.add(new contact(1, R.drawable.phone, "phone", "+79162473615"));
            contacts1.add(new contact(2, R.drawable.email, "email", "ntairov@mail.ru"));
            contacts1.add(new contact(3, R.drawable.skype, "skype", "ntairov"));
            contacts1.add(new contact(4, R.drawable.facebook, "facebook", "tairov.nail"));
            contacts1.add(new contact(5, R.drawable.vk, "vk", "ntairov"));
        }
        return contacts1;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
