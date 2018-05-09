import java.util.PriorityQueue;

class Student {
    
    String name;
    double cgpa;
    int id;
    
    Student( String name, double cgpa, int id ) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }
    
    String getName() {
        return name;
    }
    
}

class Priorities {
    PriorityQueue<Student> pq;
    Priorities() {
        pq = new PriorityQueue<>( (s1, s2) -> {
            if( s1.cgpa == s2.cgpa ) { 
                if( s1.name.equals( s2.name ) ) 
                    return Integer.compare( s1.id, s2.id );
                return s1.name.compareTo( s2.name );
            }
            return Double.compare( s2.cgpa, s1.cgpa );
        } );
    }
    
    List<Student> getStudents( List<String> events ) {        
        for( String e : events ) {
            String[] parts = e.split( "\\s+" );
            if( parts[0].equals( "ENTER" ) ) {
                pq.add( new Student( parts[1], Double.parseDouble( parts[2] ), 
                                               Integer.parseInt( parts[3] ) ) );
            }
            else {
                pq.poll();
            }
        }        
        
        List<Student> l = new ArrayList<>();
        int s = pq.size();
        for( int i=0; i<s; i++ ) {
            l.add( pq.poll() );
        }
        return l;
    }
}
