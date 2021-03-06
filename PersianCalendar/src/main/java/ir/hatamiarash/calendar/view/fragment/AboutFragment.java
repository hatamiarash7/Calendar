package ir.hatamiarash.calendar.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ir.hatamiarash.calendar.R;
import ir.hatamiarash.calendar.util.Utils;

public class AboutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        Utils utils = Utils.getInstance(getContext());
        utils.setActivityTitleAndSubtitle(getActivity(), getString(R.string.about), "");

        String version = utils.programVersion();

        TextView versionTextView = (TextView) view.findViewById(R.id.version2);
        utils.setFont(versionTextView);
        /*versionTextView.setText(utils.shape(getString(R.string.version)) + " " +
                utils.formatNumber(version.split("-")[0]));*/

        versionTextView.setText(utils.shape(getString(R.string.version)) + " " + "1");

        /*TextView licenseTextView = (TextView) view.findViewById(R.id.license);
        licenseTextView.setText("Android Persian Calendar Version " + version + "\n" +
                utils.readRawResource(R.raw.credits));*/

        //Linkify.addLinks(licenseTextView, Linkify.ALL);

        return view;
    }
}