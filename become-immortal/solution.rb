def elder_age(m, n, l, t, s = 0)
  return 0 if m <= 0 || n <= 0
  n, m = [m,n].minmax

  d = 2**Math.log(m, 2).floor
  min = [d, n].min
  i, j = [s+d-l-1, 0].max, [s-l-1, 0].max

  x = min*( i*(i+1) - j*(j+1) )/2
  
  b = elder_age(   d, n-d, l, t, d+s)
  r = elder_age( m-d, min, l, t, d+s)
  c = elder_age( m-d, n-d, l, t, s )

  return (x + c + b + r)%t
end

pp elder_age(8,5,1,100)