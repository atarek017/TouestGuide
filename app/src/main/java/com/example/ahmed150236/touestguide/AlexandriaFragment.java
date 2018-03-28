package com.example.ahmed150236.touestguide;


import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlexandriaFragment extends Fragment {


    public AlexandriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> place = new ArrayList<Place>();

        Location citadelOfQaitbay = new Location(R.string.citadel_of_qaitbay + "");
        citadelOfQaitbay.setLatitude(31.2140);
        citadelOfQaitbay.setLongitude(29.8856);
        place.add(new Place(R.string.citadel_of_qaitbay, R.string.citadel_of_qaitbay_location, R.drawable.citadelofqaitbay, citadelOfQaitbay));

        Location catacombsOfKomElshoqafa = new Location(R.string.catacombsof_komel_shoqafa + "");
        catacombsOfKomElshoqafa.setLatitude(31.2061);
        catacombsOfKomElshoqafa.setLongitude(29.8816);
        place.add(new Place(R.string.catacombsof_komel_shoqafa, R.string.catacombsof_komel_shoqafa_location, R.drawable.catacombsofkomelshoqafa, catacombsOfKomElshoqafa));

        Location graecoRomanMuseum = new Location(R.string.graeco_roman_nuseum + "");
        graecoRomanMuseum.setLatitude(31.1992);
        graecoRomanMuseum.setLongitude(29.9066);
        place.add(new Place(R.string.graeco_roman_nuseum, R.string.graeco_roman_nuseum_location, R.drawable.graecoromanmuseum, graecoRomanMuseum));

        Location calligraphyMuseumMoharamBek = new Location(R.string.calligraphy_museum_moharam_bek + "");
        calligraphyMuseumMoharamBek.setLatitude(31.1951);
        calligraphyMuseumMoharamBek.setLongitude(29.9131);
        place.add(new Place(R.string.calligraphy_museum_moharam_bek, R.string.calligraphy_museum_moharam_bek_location, R.drawable.calligraphymuseum, calligraphyMuseumMoharamBek));

        Location elMontazah = new Location(R.string.el_montazah + "");
        elMontazah.setLatitude(31.205753);
        elMontazah.setLongitude(29.924526);
        place.add(new Place(R.string.el_montazah, R.string.el_montazah_location, R.drawable.elmontazah, elMontazah));

        final placeAdpter placeAdpter = new placeAdpter(getActivity(), place);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = place.get(position).getcLocation().getLatitude();
                double lon = place.get(position).getcLocation().getLongitude();
                Location keyword = place.get(position).getcLocation();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(String.valueOf(keyword)));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        return rootView;

    }

}
