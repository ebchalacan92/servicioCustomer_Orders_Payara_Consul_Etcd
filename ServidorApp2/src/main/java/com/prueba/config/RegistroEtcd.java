package com.prueba.config;
import com.coreos.jetcd.Client;
import com.coreos.jetcd.KV;
import com.coreos.jetcd.data.ByteSequence;
import com.coreos.jetcd.data.KeyValue;
import com.coreos.jetcd.kv.GetResponse;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.microprofile.config.ConfigProvider;


public class RegistroEtcd {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		 Integer puerto = ConfigProvider.getConfig().getValue("payara.instance.http.port", Integer.class);
		
        Client client = Client.builder().endpoints("http://127.0.0.1:2379").build();
        ByteSequence key = ByteSequence.fromString("/ServidorApp2/");
        ByteSequence value = ByteSequence.fromString("127.0.0.1:"+puerto);

        // put the key-value
        KV kvClient=client.getKVClient();

        kvClient.put(key,value).get();

        // get the CompletableFuture
        CompletableFuture<GetResponse> getFuture = kvClient.get(key);

        // get the value from CompletableFuture
        GetResponse response = getFuture.get();

        for(KeyValue kv:response.getKvs())
        {
            System.out.println(kv.getKey()+" == "+kv.getValue());
        }

        System.out.println(response);

    }

}
