        Arrays.sort( s, (i1, i2) -> {
            if( i1 != null && i2 != null ) {
                BigDecimal bi1 = new BigDecimal( i1 );
                BigDecimal bi2 = new BigDecimal( i2 );

                return bi2.compareTo( bi1 );
            }
            return 0;
        });
