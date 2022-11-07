package com.example.laboratorio2


import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var etPersonName: EditText? = null
    private var etPersonEdad: EditText? = null
    private var etPersonDepartament: EditText? = null
    private lateinit var tvNombre: TextView
    private lateinit var tvApellido: TextView
    private lateinit var tvDepartamento: TextView
    private var lvLista: ListView? = null

    var nombre = etPersonName?.text.toString()
    private var Lista = arrayListOf(nombre)
    private var posiciones = arrayListOf("1") + 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPersonName = findViewById(R.id.et_PersonName)
        etPersonEdad = findViewById(R.id.et_PersonEdad)
        etPersonDepartament = findViewById(R.id.et_PersonDepartament)
        //lvLista = findViewById(R.id.lv_Lista)


        var adaptador: ArrayAdapter<String> =
            ArrayAdapter<String>(this, R.layout.lista_activity, Lista)
        lvLista?.adapter = adaptador


        lvLista?.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                tvNombre?.text =
                    "Nombre ${lvLista?.getItemAtPosition(position)} es ${posiciones[position]}"
                /*tvApellido?.text =
                    "apellido ${lvLista?.getItemAtPosition(position)} es ${posiciones[position]}"
                tvDepartamento?.text =
                    "Departamento ${lvLista?.getItemAtPosition(position)} es ${posiciones[position]}"*/
            }

        }


    }
    fun btnSiguiente(vista : View){
        val ventana : Intent= Intent(applicationContext,ListView ::class.java)
    }
    fun Guardado (v:View){
        /*tvNombre.visibility = View.INVISIBLE
        tvApellido.visibility = View.INVISIBLE
        tvDepartamento.visibility = View.INVISIBLE*/

        if(etPersonName?.isEnabled ?: false){
            println("Ingrese su nombre")

        }
        else{
            if (etPersonEdad?.isEnabled ?: false){
                println("Ingese su Edad")
            }
            else{
                if (etPersonDepartament?.isEnabled ?: false){
                    println("Ingrese su departamento")
                }



            }

        }
        /*if(rbIngresar.isChecked()==true){
            etnIngresar.visibility = View.VISIBLE
        }
        if(rbRetirar.isChecked()==true){
            etnRetirar.visibility = View.VISIBLE
        }
        if(rbSalir.isChecked()==true){
            tvVerSaldo.visibility = View.VISIBLE
            tvVerSaldo.text = "Adios Usuario"
            Toast.makeText(this,"Has decidido salir del programa", Toast.LENGTH_SHORT).show()
        }*/
    }
}

