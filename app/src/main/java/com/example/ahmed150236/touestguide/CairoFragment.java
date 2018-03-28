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
public class CairoFragment extends Fragment {


    public CairoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> place = new ArrayList<Place>();
        Location cairoTower = new Location(R.string.cairo_tower + "");
        cairoTower.setLatitude(30.0459);
        cairoTower.setLongitude(31.2243);
        place.add(new Place(R.string.cairo_tower, R.string.cairo_tower_location, R.drawable.cairotower, cairoTower));

        Location egyptMuseum = new Location(R.string.egypt_museum + "");
        egyptMuseum.setLatitude(30.0478);
        egyptMuseum.setLongitude(31.2336);
        place.add(new Place(R.string.egypt_museum, R.string.egypt_museum_location, R.drawable.egyptianmuseum, egyptMuseum));

        Location mosqueOfMohammedAli = new Location(R.string.mosque_moha_ali + "");
        mosqueOfMohammedAli.setLatitude(30.0287);
        mosqueOfMohammedAli.setLongitude(31.2599);
        place.add(new Place(R.string.mosque_moha_ali, R.string.mosque_moha_ali_location, R.drawable.musuemmohammedali, mosqueOfMohammedAli));

        Location PyramidofDjoser = new Location(R.string.pyramid_djoser + "");
        PyramidofDjoser.setLatitude(29.8713);
        PyramidofDjoser.setLongitude(31.2165);
        place.add(new Place(R.string.pyramid_djoser, R.string.pyramid_djoser_location, R.drawable.pyramidofdjoser, PyramidofDjoser));

        Location museumofIslamicArt = new Location(R.string.museum_of_islamicart + "");
        museumofIslamicArt.setLatitude(30.0444);
        museumofIslamicArt.setLongitude(31.2524);
        place.add(new Place(R.string.museum_of_islamicart, R.string.museum_of_islamicart_location, R.drawable.museumofislamicart, museumofIslamicArt));

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
