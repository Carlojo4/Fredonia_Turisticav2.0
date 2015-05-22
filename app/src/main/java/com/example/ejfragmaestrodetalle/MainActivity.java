package com.example.ejfragmaestrodetalle;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements
		TituloFragment.onTituloSelectedListener {
    public int position=0;
    HotelsFragment fragmenth = new HotelsFragment();
    BarsFragment fragmentb = new BarsFragment();
    TurismFragment fragmett = new TurismFragment();
    InfoFragment fragmenti = new InfoFragment();
    AboutFragment fragmenta = new AboutFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
            if (findViewById(R.id.fragment_container) != null) {
                if (savedInstanceState != null) {
                    return;
                }
                TituloFragment fragment = new TituloFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, fragment, null).commit();
            }

}


	@Override
	public void onTituloSelected(int position) {
		
		ContenidoFragment contFragment = (ContenidoFragment) getSupportFragmentManager()
				.findFragmentById(R.id.contenidoFragment);

		if (contFragment != null ) {
			contFragment.actualizarContenido(position);
		}
        else {
			contFragment = new ContenidoFragment();
			Bundle args = new Bundle();
			args.putInt(ContenidoFragment.POSICION, position);
			contFragment.setArguments(args);

        }
        if (position==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmenth).addToBackStack(null).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.contenidoFragment, fragmenth).addToBackStack(null).commit();
        }
        else if (position==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentb).addToBackStack(null).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.contenidoFragment, fragmentb).addToBackStack(null).commit();
        }
        else if (position==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmett).addToBackStack(null).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.contenidoFragment, fragmett).addToBackStack(null).commit();

        }
        else if (position==3){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmenti).addToBackStack(null).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.contenidoFragment, fragmenti).addToBackStack(null).commit();

        }
        else if (position==4){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmenta).addToBackStack(null).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.contenidoFragment, fragmenta).addToBackStack(null).commit();
        }

	}

}
