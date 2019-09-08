PRIMA DI INIZIARE
attiva activemq (download https://activemq.apache.org/components/classic/download/)
cd [PATHdelDOWNLOAD]/bin/linux-x86-64/
./activemq start

ora broker attivo in localhost sulla porta 61616
------------------------------------------------------------------------------------------------
2 progetti
JMS_Server : 2 classi principali
                      - NotificatoreAcquisto: si occupa di ricevere le offerte sul topic "Ordini". Quando ne arriva una,
                        manda un messaggio al client con scritto l'esito dell'offerta
                      - ProduttoreQuotazioni: produce le varie azioni e i valori a random, dopodiche li manda al
                        client pubblicando un messaggio su "Quotazioni" (ci sarebbe pure un listener ma non viene usato
JMS_Client: una sola classe, subscriber sia di "Quotazioni" dove riceve ordini filtrati per valore [valoreMin,valoreMax],
                    sia subscriber di "Ordini" dove riceve la notifica sull'esito dell'offerta.
                    In aggiunta, e' producer di "Ordini" che possono essere mandati ogni 20 secondi.