package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.sax.RootElement;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView textView;
    Uri address;
    Intent openlinkIntent;
    Intent dialIntent;
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

        View v1 = inflater.inflate(R.layout.fragment_contacts2, container, false);
        final TextView textView = (TextView) v1.findViewById(R.id.txtE);
        ListView lv = (ListView) v1.findViewById(R.id.lv);
        contacts1.clear();
        lv.setAdapter(new customAdapter(loadData()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> v1, View v, int position, long id) {
            switch (position) {
                case 0:
                    dialIntent = new Intent(Intent.ACTION_DIAL);
                    dialIntent.setData(Uri.parse("tel:" + "79162473615"));
                    startActivity(dialIntent);
                    break;
                case 1:
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    break;
                case 2:
                    dialIntent = new Intent(Intent.ACTION_DIAL);
                    dialIntent.setData(Uri.parse("tel:" + "ntairov"));
                    startActivity(dialIntent);
                    break;
                case 3:
                    address = Uri.parse("https://www.facebook.com/nail.tairov");
                    openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                    startActivity(openlinkIntent);
                    break;
                case 4:
                    address = Uri.parse("https://vk.com/ntairov");
                    openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                    startActivity(openlinkIntent);
                    break;
            }
            }
        });

        return v1;

    }



    public List<contact> loadData() {
        for(int i =0; i<1;i++){
            System.out.println("Начал загрузку---"+i);
            contacts1.add(new contact("1", R.drawable.phone, "phone:", "+79162473615"));
            contacts1.add(new contact("2", R.drawable.email, "email:", "ntairov@mail.ru"));
            contacts1.add(new contact("3", R.drawable.skype, "skype:", "ntairov"));
            contacts1.add(new contact("4", R.drawable.facebook, "facebook:", "tairov.nail"));
            contacts1.add(new contact("5", R.drawable.vk, "vk:", "ntairov"));
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
