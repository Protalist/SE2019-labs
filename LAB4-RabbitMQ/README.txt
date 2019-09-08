Vedi tutorial se serve su RabbitMQ.com

leggi i commenti

L'ordine dei tutorial 
1) Hello World : una semplice queue dove il server fa da broker e pubblica. I client collegati ricevono a turno 
                           (prima il primo client avviato, poi il secondo ... finche' non rinizia il giro).
                            --> usato anche in lab5
2) WorkQueue: i client sono in competizione (niente ordine di avvio) e devono mandare l'ack prima di 
                           leggere di nuovo
3) PublishSubscribe_BroadCast: manda il messaggio a tutte le queue conosciute dall'exchange
4)Routing: exchange di tipo routing: i client ricevono i messaggi indirizzati alle queue con un certo livello di 
                   severity
5) Topic: essenzialmente come fa ActiveMq = Publisher/Subscriber, ma ci sono i binding fighi con * e #
              --> usato anche in lab5