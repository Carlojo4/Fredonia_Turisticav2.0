package com.example.ejfragmaestrodetalle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ContenidoFragment extends Fragment {
	public static final String POSICION = "position";
	int position = -1;
    HotelsFragment fragmenth = new HotelsFragment();
    BarsFragment fragmentb = new BarsFragment();
    TurismFragment fragmentt = new TurismFragment();
    InfoFragment fragmenti = new InfoFragment();
    AboutFragment fragmenta = new AboutFragment();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (savedInstanceState != null){
			position = savedInstanceState.getInt("position");
		}
        if (position==0){
		    return inflater.inflate(R.layout.fragment_hotels, container, false);
	    }
        else if (position==1){
            return inflater.inflate(R.layout.fragment_bars, container, false);
        }
        else if (position==2){
            return inflater.inflate(R.layout.fragment_turism, container, false);
        }
        else if (position==3){
            return inflater.inflate(R.layout.fagment_info, container, false);
        }
        else if (position==4){
            return inflater.inflate(R.layout.fragment_about, container, false);
        }
        else
            return inflater.inflate(R.layout.contenido_fragment, container, false);
    }
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(POSICION, position);
	}

	@Override
	public void onStart() {
		super.onStart();
		Bundle args = getArguments();
		if (args != null){
			actualizarContenido(args.getInt(POSICION));
		}else if(position != -1){
			actualizarContenido(position);
		}
	}
	public void actualizarContenido(int position){
/*        MainActivity main = new MainActivity();
        main.onTituloSelected(position);*/
        //FragmentManager manager=getSupportFragmentManager();
        //FragmentTransaction transaction  = manager.beginTransaction();
        //HotelsFragment fragmenth = new HotelsFragment();
        //if position

        FragmentManager fragmentmanager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();

        if (position==0) {
             fragmentTransaction.replace(R.id.contenidoFragment,fragmenth).commit();
        }
        else if (position==1) {

                fragmentTransaction.replace(R.id.contenidoFragment,fragmentb).commit();

        }
        else if (position==2) {

                fragmentTransaction.replace(R.id.contenidoFragment,fragmentt).commit();

        }
        else if (position==3) {

                fragmentTransaction.replace(R.id.contenidoFragment,fragmenti).commit();

        }
        else if (position==4) {

                fragmentTransaction.replace(R.id.contenidoFragment,fragmenta).commit();

        }
		this.position = position;
	}
}
